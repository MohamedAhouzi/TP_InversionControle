package dao;

public class DaoImpl implements IDao {

    @Override
    public double getData() {
        System.out.println("Version base de donnees");
        double temp=24;
        return temp;
    }
}
