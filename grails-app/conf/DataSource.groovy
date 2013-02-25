dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "grails"
    password = "server"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
          // one of 'create', 'create-drop','update'
          dbCreate = "update"
          // NOTE: the JDBC connection string should be
          //       all on the same line.
          url = "jdbc:mysql://localhost:3306/racetrack_dev?autoreconnect=true"
        } 
    }
    test {
        dataSource {
            dbCreate = "update"
          url = "jdbc:mysql://localhost:3306/racetrack_dev?autoreconnect=true"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
