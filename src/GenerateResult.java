import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class GenerateResult {
  static final String DATA_PATH = "/home/eleonora/Documents/RerformanceReports/resouces/data.json";
  static final String REPORT_PATH =
      "/home/eleonora/Documents/RerformanceReports/resouces/report.json";

  public static Datas readDatasFile(String path) throws FileNotFoundException {
    Gson gson = new Gson();
    BufferedReader br = null;
    br = new BufferedReader(new FileReader(path));
    Datas datas = gson.fromJson(br, Datas.class);
    return datas;
  }

  public static ReportDeff readReportFile(String path) throws FileNotFoundException {
    Gson gson = new Gson();
    BufferedReader br = null;
    br = new BufferedReader(new FileReader(path));
    ReportDeff report = gson.fromJson(br, ReportDeff.class);
    return report;
  }

  public static void generateCSVResullt(
      String fileName, String dataFilePath, String reportFilPath) {
    Datas datas = null;
    try {
      datas = readDatasFile(dataFilePath);
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

    ReportDeff report = null;
    try {
      report = readReportFile(reportFilPath);
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    try (PrintWriter writer = new PrintWriter(new File(fileName))) {

      StringBuilder sb = new StringBuilder();
      sb.append("Result");
      sb.append('\n');
      sb.append("Name  ");
      sb.append(',');
      sb.append("Score");
      sb.append('\n');
      double score = 0;
      for (Data dt : datas.getDatas()) {
        if (dt.getSalesPeriod() <= report.getPeriodLimit()) {
          if (report.isUseExpirienceMultiplier()) {
            score = dt.getTotalSales() / (dt.getSalesPeriod() * dt.getExperienceMultiplier());
          } else {
            score = dt.getTotalSales() / dt.getSalesPeriod();
          }
          sb.append(dt.getName());
          sb.append(",");
          sb.append(score);
          sb.append("\n");
        }
      }

      writer.write(sb.toString());

      System.out.println("done!");

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String command;
    System.out.println("Enter the command - 'generateCSV fileName dataFile reportFile");
    command = input.nextLine();

    String[] splitted = command.split("\\s+");

    if (splitted[0].equals("generateCSV")) {
      generateCSVResullt(splitted[1], splitted[2], splitted[3]);
    } else {
      System.out.println("Inavalid input!!!");
    }
  }
}
