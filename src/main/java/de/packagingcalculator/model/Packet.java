package de.packagingcalculator.model;

import java.util.Arrays;

/**
 * This can hold all information related to a Packet category
 */
public class Packet {
    private double[] dimensions;
    private int weight; //in gramm
    private double price; //in €

    private static double INVALID_PRICE = -1.0;

    /**
     * Generates a Packet with the according values
     * Sets the price to a negative value. getPrice will throw an {@link UnsupportedOperationException} if called.
     *
     * @param d1 one dimension in mm
     * @param d2 one dimension in mm
     * @param d3 one dimension in mm
     * @param w  the weight in g
     */
    public Packet(double d1, double d2, double d3, int w) {
        this(d1, d2, d3, w, INVALID_PRICE);
    }

    /**
     * For Strings
     *
     * @param d1
     * @param d2
     * @param d3
     * @param w
     */
    @Deprecated
    public Packet(String d1, String d2, String d3, String w) {
        this(Double.parseDouble(d1), Double.parseDouble(d2), Double.parseDouble(d3), Integer.parseInt(w));
    }

    /**
     * Generates a Packet with the according values
     *
     * @param d1 one dimension in mm
     * @param d2 one dimension in mm
     * @param d3 one dimension in mm
     * @param w the weight in g
     * @param p the price of this category
     */
    public Packet(double d1, double d2, double d3, int w, double p) {
        dimensions = new double[3];
        dimensions[0] = d1;
        dimensions[1] = d2;
        dimensions[2] = d3;
        Arrays.sort(dimensions);

        weight = w;
        price = p;
    }

    /**
     * Checks the given package size against the requirements of this pricing category
     *
     * @param d1 one dimension in mm
     * @param d2 one dimension in mm
     * @param d3 one dimension in mm
     * @param w  the weight in g
     * @return true if the passed size fits, else false
     */
    boolean fitsPackage(double d1, double d2, double d3, int w){
        boolean fits = false;

        double[] packageDim = new double[3];
        packageDim[0] = d1;
        packageDim[1] = d2;
        packageDim[2] = d3;
        Arrays.sort(packageDim);

        if(packageDim[0] <= dimensions[0] &&
                packageDim[1] <= dimensions[1] &&
                packageDim[2] <= dimensions[2] &&
                w <= weight) {
            fits = true;
        }

        return fits;
    }

    /**
     * Test if the given Packet fits this border package
     *
     * @param p the Package to test
     * @return true if the Package fits
     */
    boolean fitsPackage(Packet p) {
        return fitsPackage(p.dimensions[0], p.dimensions[1], p.dimensions[2], p.weight);
    }

    /**
     * Returns the price of this border packet
     * @return a double in €
     * @throws UnsupportedOperationException if the price is less than zero
     */
    public double getPrice() {
        if (price < 0) {
            throw new UnsupportedOperationException("No valid price associated with this packet");
        }
        return price;
    }

    /**
     * Adds a other packet to this packet and returns the stacked packet.
     * <p>
     * This assumes that both dimensions are alredy sorten in ascending order by {@link Arrays#sort(double[])}
     *
     * @param p the packet to add
     * @return a packet containing the dimensions of the stacked package
     */
    public Packet addPacket(Packet p) {

        return new Packet(p.dimensions[0] + this.dimensions[0], // add the smallest dimension
                Math.max(p.dimensions[1], this.dimensions[1]), // get the bigger of the second dimension
                Math.max(p.dimensions[2], this.dimensions[2]), // get the biggest of the biggest dimensions
                this.weight + p.weight); // add the weights
    }

    /**
     * Adds multiple Packets to this one and returns the new required packet.
     *
     * @param packets The packets to add
     * @return a new instance of packet with the required size.
     */
    public Packet addPackets(Iterable<Packet> packets) {
        Packet sum = this;
        for (Packet p : packets) {
            sum = sum.addPacket(p);
        }
        return sum;
    }

    @Override
    public String toString() {
        return dimensions[0] + "/" +
                dimensions[1] + "/" +
                dimensions[2] + "/" +
                weight;
    }
}
