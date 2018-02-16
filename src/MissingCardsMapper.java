import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MissingCardsMapper extends MapReduceBase implements
		Mapper<LongWritable, // Input key Type
				Text, // Input value Type
				Text, // Output key Type
				Text> // Output value Type
{

	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {
		try {
			String textLine = value.toString();
			String arr[] = textLine.split(",");
			output.collect(new Text(arr[0]), new Text(arr[1]));
		} catch (ArrayIndexOutOfBoundsException ae) {
			ae.printStackTrace();
		}

	}
}
