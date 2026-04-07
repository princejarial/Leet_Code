import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Stats {
        int totalTime;
        int count;

        Stats(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    Map<Integer, CheckIn> checkInMap;
    Map<String, Stats> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);
        
        String key = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        Stats stats = routeMap.getOrDefault(key, new Stats(0, 0));
        stats.totalTime += travelTime;
        stats.count += 1;

        routeMap.put(key, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        Stats stats = routeMap.get(key);

        return (double) stats.totalTime / stats.count;
    }
}