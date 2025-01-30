public class Product {

    private String id;
    private String name;
    private String desc;
    private double cost;
    static private int IDSeed =  1;

    public static void setIDSeed(int IDSeed) {
        Product.IDSeed = IDSeed;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public Product(String id, String name, String desc, double cost)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    public Product(String name, String desc, double cost)
    {
        this.id = this.genIDNum();
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    public String getIDNum() {
        return id;
    }

    private String genIDNum() {
        String newID = "" + IDSeed;
        while(newID.length() < 8)
        {
            newID = "0" + newID;
        }

        IDSeed++;

        return newID;
    }

    public String getName() {return name;}
    public String getDesc() {return desc;}
    public double getCost() {return cost;}
    public void setName(String newName) {name = newName;}
    public void setDesc(String newDesc) {desc = newDesc;}
    public void setCost(double cost) {this.cost = cost;}

    @Override
    public String toString() {
        return "Product {id=" + id + ",\n name=" + name + ",\n desc=" + desc + ",\n cost=" + cost +"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && desc.equals(product.desc) && cost == product.cost;
    }

    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.id + DQ + ",";
        retString += DQ + "name" + DQ + ":" + DQ + this.name + DQ + ",";
        retString += DQ + "desc" + DQ + ":" + DQ + this.desc + DQ + ",";
        retString += DQ + "cost" + DQ + ":" + DQ + this.cost + "}";

        return retString;
    }

    public String toXMLRecord() {
        String retString = "";

        retString = "<Product>" + "<IDNum>" + this.id + "</IDNum>";
        retString += "<Name>" + this.name + "</Name>";
        retString += "<Desc>" + this.desc + "</Desc>";
        retString += "<Cost>" + this.cost + "</Cost></Product>";

        return retString;
    }

    public String toCSVRecord(){
        return this.id+", "+ this.name + ", "+ this.desc+", "+this.cost;
    }
}
