package wangk6.travelling.interfaces

import wangk6.travelling.enums.DownloadStatus

interface IDataDownloadComplete {
    fun onDownloadComplete(data: String, status: DownloadStatus)
}