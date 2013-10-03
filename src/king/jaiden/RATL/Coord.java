package king.jaiden.RATL;

public class Coord {
	private double x,y,z;

	/**
	 * Creates a new Coord Object
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param z Z Coordinate
	 */
	public Coord(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * Returns X coordinate
	 * @return X coordinate
	 */
	public double getX() {
		return x;
	}
	/**
	 * Sets the X coordinate
	 * @param x The new X coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Returns Y coordinate
	 * @return Y coordinate
	 */
	public double getY() {
		return y;
	}
	/**
	 * Sets the Y coordinate
	 * @param y The new Y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Returns Z coordinate
	 * @return Z coordinate
	 */
	public double getZ() {
		return z;
	}
	/**
	 * Sets the Z coordinate
	 * @param z The new Z coordinate
	 */
	public void setZ(double z) {
		this.z = z;
	}
	/**
	 * Compares the Coord with the given Coord
	 * @param c
	 * @return True if both Coords have equal coordinates
	 */
	public boolean equals(Coord c){
		if(c.getX()==x&&c.getY()==y&&c.getZ()==z)
			return true;
		else
			return false;
	}
	/**
	 * Adds the given Coord's coordinates to this Coord's coordinates
	 * @param c
	 * @return Returns itself.
	 */
	public Coord add(Coord c){
		x += c.getX();
		y += c.getY();
		z += c.getZ();
		return this;
	}
	/**
	 * Calculates the radius of the Coord.
	 * @return Radius from the origin as a positive number.
	 */
	public double getRadius(){
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
	}
	
	/**
	 * Copies this Coord
	 * @return A Coord with the same coordinates
	 */
	public Coord copy(){
		return new Coord(x,y,z);
	}
}
