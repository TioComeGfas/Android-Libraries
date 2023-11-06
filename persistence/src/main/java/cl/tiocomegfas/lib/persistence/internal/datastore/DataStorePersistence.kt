package cl.tiocomegfas.lib.persistence.internal.datastore

import cl.tiocomegfas.lib.persistence.Persistence

internal class DataStorePersistence: Persistence {

    override suspend fun <T> write(key: String, value: T) {
        TODO("Not yet implemented")
    }

    override suspend fun <T> read(key: String, default: T): T {
        TODO("Not yet implemented")
    }

    override suspend fun contains(key: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }

    override suspend fun remove(key: String) {
        TODO("Not yet implemented")
    }
}