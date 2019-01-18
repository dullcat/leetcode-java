package uber_trace_cache;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class UberTraceCache {

    // Insert your Solution class here

    /* Implement a driver GPS trace cache. */
        public static class Location {
            public double latitude;
            public double longitude;

            public Location(double lat, double lng) {
                latitude = lat;
                longitude = lng;
            }
        }


    /* Sample Usage
    cache.insert("Driver A", locationA, 100)
    cache.insert("Driver A", locationB, 200)

    cache.searchLocation("Driver A", 100) => locationA
    cache.searchLocation("Driver A", 120) => locationA
    cache.searchLocation("Driver A", 190) => locationB
    */



        static class GPSTraceCacheTime {
            Map<String, TreeMap<Integer, Location>> driverTrace;

            GPSTraceCacheTime () {
                driverTrace = new HashMap<String, TreeMap<Integer, Location>>();
            }
            /**
             * Periodically the mobile app of the driver calls this method
             * to store a new GPS location.
             *
             * driverID: a string key of driver identification
             * location: a GPS coordinate
             * epochTimestam: a integer representation of UTC time
             */
            void insert(String driverID, Location location, int epochTimestamp) {
                if (!driverTrace.containsKey(driverID)) {
                    driverTrace.put(driverID, new TreeMap<Integer,Location>());
                }
                driverTrace.get(driverID).put(epochTimestamp, location);
            }

            /**
             * Internal service can query the approximate location of a
             * driver given certain time. The search will return the location
             * of the time that is closest to the input epochTimestamp.
             *
             * driverID: a string key of driver identification
             * epochTimestam: a integer representation of UTC time
             */
            Location searchLocation(String driverID, int epochTimestamp) {
                if (!driverTrace.containsKey(driverID)) {
                    return null;
                }
                TreeMap map = driverTrace.get(driverID);
                Integer t = (Integer) map.get(epochTimestamp);
                if (t != null)
                    return (Location) map.get(t);

                Integer lower = (Integer) map.lowerKey(epochTimestamp);
                Integer higher = (Integer) map.higherKey(epochTimestamp);

                if (lower == null)
                    return (Location) map.get(higher);
                if (higher == null)
                    return (Location) map.get(lower);

                if (Math.abs(lower-epochTimestamp) <= Math.abs(higher-epochTimestamp)) {
                    return (Location) map.get(lower);
                }
                else {
                    return (Location) map.get(higher);
                }
            }

    }
    public static class UnitTest {
        @Test
        public void testUberTraceCache() {
            GPSTraceCacheTime cache = new GPSTraceCacheTime();
            Location locationA = new Location(1,2);
            Location locationB = new Location(3,4);
            cache.insert("Driver A", locationA, 100);
            cache.insert("Driver A", locationB, 200);

            System.out.println(cache.searchLocation("Driver A", 100).latitude);// => locationA
            System.out.println(cache.searchLocation("Driver A", 120).latitude);// => locationA
            System.out.println(cache.searchLocation("Driver A", 190).latitude);// => locationB
            System.out.println(cache.searchLocation("Driver A", 150).latitude);// => locationB

        }
    }
}

