public class Data {
  private String name;
  private int totalSales;
  private int salesPeriod;
  private double experienceMultiplier;

  public String getName() {
    return name;
  }

  public int getTotalSales() {
    return totalSales;
  }

  public int getSalesPeriod() {
    return salesPeriod;
  }

  public double getExperienceMultiplier() {
    return experienceMultiplier;
  }

  @Override
  public String toString() {
    return "Data{" +
            "name='" + name + '\'' +
            ", totalSales=" + totalSales +
            ", salesPeriod=" + salesPeriod +
            ", experienceMultiplier=" + experienceMultiplier +
            '}';
  }
}
