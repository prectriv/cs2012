public class Coord {
    public Integer x;
    public Integer y;

    public Coord(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Double distanceFrom(Coord c){
        // sqrt( (x1-x2)^2 + (y1-y2)^2)
        return Math.sqrt(Math.pow(this.x - c.x,2) + Math.pow(this.y - c.y, 2));
    }


}
