package com.example.mygooglebook.remote

class SeachRepository(
    remote: RemoteDataSource,
    local: DataBaseSource
): Repository<String>(remote,local)