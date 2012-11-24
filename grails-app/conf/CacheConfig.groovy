config = {
    cache {
        name 'tokenByUsername'
        maxElementsInMemory 1000
        timeToIdleSeconds 2*60*60
        eternal false
        overflowToDisk false
        maxElementsOnDisk 0
    }
    cache {
        name 'usernameByToken'
        maxElementsInMemory 1000
        timeToIdleSeconds 2*60*60
        eternal false
        overflowToDisk false
        maxElementsOnDisk 0
    }
}
