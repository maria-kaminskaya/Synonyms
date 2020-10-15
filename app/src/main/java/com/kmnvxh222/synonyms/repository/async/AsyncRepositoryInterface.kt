package com.kmnvxh222.synonyms.repository.async

import java.util.concurrent.ThreadPoolExecutor

interface AsyncRepositoryInterface {
    fun close(threadPoolExecutor: ThreadPoolExecutor)
}