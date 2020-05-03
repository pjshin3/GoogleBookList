package com.example.mygooglebook.remote

class ApiRepository(
    remote: RemoteDataSource,
    local: DataBaseSource
): Repository<String>(remote,local)