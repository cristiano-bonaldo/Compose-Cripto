package cvb.com.br.composecripto.di

import cvb.com.br.composecripto.data.api.service.ApiService
import cvb.com.br.composecripto.data.data_source.remote.CoinDetailRemoteDataSource
import cvb.com.br.composecripto.data.data_source.remote.CoinRemoteDataSource
import cvb.com.br.composecripto.data.repository.CoinDetailRepositoryImpl
import cvb.com.br.composecripto.data.repository.CoinRepositoryImpl
import cvb.com.br.composecripto.domain.data_source.CoinDataSource
import cvb.com.br.composecripto.domain.data_source.CoinDetailDataSource
import cvb.com.br.composecripto.domain.repository.CoinDetailRepository
import cvb.com.br.composecripto.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ) =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesCoinRemoteDataSource(apiService: ApiService): CoinDataSource =
        CoinRemoteDataSource(apiService)

    @Singleton
    @Provides
    fun providesCoinDetailRemoteDataSource(apiService: ApiService): CoinDetailDataSource =
        CoinDetailRemoteDataSource(apiService)


    @Singleton
    @Provides
    fun providesCoinRepository(coinDataSource: CoinDataSource): CoinRepository =
        CoinRepositoryImpl(coinDataSource)

    @Singleton
    @Provides
    fun providesCoinDetailRepository(coinDetailDataSource: CoinDetailDataSource): CoinDetailRepository =
        CoinDetailRepositoryImpl(coinDetailDataSource)

}

