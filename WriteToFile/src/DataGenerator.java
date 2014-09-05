
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataGenerator {
private static Log logger = LogFactory.getLog(DataGenerator.class);

public static void main(String[] args) {
String FIELD_DELIMITER = ",";
long size = 100000;
System.out.println(size);
long startTime = System.currentTimeMillis();
try {
Date date = new Date();
SimpleDateFormat sdf2 = new SimpleDateFormat("MM", Locale.ENGLISH);
String outputString = sdf2.format(date);
StringBuilder stringBuilder = new StringBuilder();
Calendar mCalendar = Calendar.getInstance();
File file = new File("/home/chanchal/filedata/data.txt");
File metaFile = new File("/home/chanchal/filedata/MyMetaData.txt");
// if file doesnt exists, then create it
if (!file.exists()) {
new File(file.getParent()).mkdirs();
new File(metaFile.getParent()).mkdirs();
metaFile.createNewFile();
file.createNewFile();
}
PrintWriter pw = new PrintWriter(file.getAbsoluteFile());
PrintWriter mpw = new PrintWriter(metaFile.getAbsoluteFile());
int count = 0;
while (count < size) {
count++;
System.out.println(count);
stringBuilder.setLength(0);
stringBuilder.append(mCalendar.get(Calendar.YEAR) + "" + FIELD_DELIMITER);
stringBuilder.append(outputString + FIELD_DELIMITER);
stringBuilder.append(StringUtils.leftPad("ASDR" + count, 19, '0'));
stringBuilder.append("\n");
pw.write(stringBuilder.toString());

}
long endTime = System.currentTimeMillis();
logger.info("Data Generator completed in  " + (endTime - startTime) / 1000 + " seconds.");
mpw.write("Row Count = " + count + "\n");
mpw.write("Time taken= " + (endTime - startTime) / 1000 + " seconds.");
mpw.close();
pw.close();
System.out.println("Done");
} catch (IOException e) {
e.printStackTrace();
}
long endTime = System.currentTimeMillis();
logger.info("Data Generator completed in  " + (endTime - startTime) / 1000 + " seconds.");

}
}