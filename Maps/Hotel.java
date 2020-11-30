// 1. User wants to see all Atracttion, Hotel, Cafe 
// 2. The user is currently looking at a specific range of map 
//     (coordinateXStart -> coordinateXEnd, coordianteYStart --> coordianteYEnd)

public class Map {
    private float coordinateXStart;
    private float coordinateXEnd;
    private float coordinateYStart;
    private float coordinateYEnd;

    private static int width;
    private static int height;

    public Map(int width, int height, float coordinateXStart, float coordinateYStart) {
        this.coordinateXStart = coordinateXStart;
        this.coordinateXEnd = this.coordinateXEnd + width;
        this.coordinateYStart = coordinateYStart;
        this.coordinateYEnd = this.coordinateYStart + height;
    }

    public void moveMap(float moveX, float moveY) {
        this.coordinateXStart += moveX;
        this.coordinateXEnd += moveX;
        this.coordinateYStart += moveY;
        this.coordinateYEnd += moveY;
    }
}

public class App {
    Map view = new Map();
}

public enum MapItemType {
    Attraction,
    Hotel,
    Cafe
}

public class MapItems {
    private final float coordinateX;
    private final float coordinateY;
    private final String name;
    private final MapItemTypes type;

    public MapItems(float coordinateX, float coordinateY, String name, MapItemType type) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.name = name;
        this.type = type;
    }

    public float getCoordinateX() {
        return this.coordinateX;
    }

    public float getCoordinateY() {
        return this.coordinateY;
    }

}

public class Attractions extends MapItems {

    public Attractions(float coordinateX, float coordinateY, String name) {
        super(coordinateX, coordinateY, name, MapItemType.Attraction);
    }
}

public class Hotel extends MapItems {
    ArrayList<Rooms> rooms;

    public Hotel(float coordinateX, float coordinateY, String name) {
        super(coordinateX, coordinateY, name, MapItemType.Hotel);
    }
}

public class Cafe extends MapItems{
    ArrayList<Foods> foods;

    public Cafe(float coordinateX, float coordinateY, String name) {
        super(coordinateX, coordinateY, name, MapItemType.Cafe);
    }

}

