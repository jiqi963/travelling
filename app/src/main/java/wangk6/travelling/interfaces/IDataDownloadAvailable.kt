package wangk6.travelling.interfaces

interface IDataDownloadAvailable {
    fun onDataAvailable(data: String)
    fun onError(e: Exception)
}