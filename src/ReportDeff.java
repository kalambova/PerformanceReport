public class ReportDeff {
  private int topPerformersThreshold;
  private boolean useExprienceMultiplier;
  private int periodLimit;

  public int getTopPerformersThreshold() {
    return topPerformersThreshold;
  }

  public boolean isUseExpirienceMultiplier() {
    return useExprienceMultiplier;
  }

  public int getPeriodLimit() {
    return periodLimit;
  }

  @Override
  public String toString() {
    return "ReportDeff{" +
            "topPerformersThreshold=" + topPerformersThreshold +
            ", useExpirienceMultiplier=" + useExprienceMultiplier +
            ", periodLimit=" + periodLimit +
            '}';
  }
}
