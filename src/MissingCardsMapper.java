
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

//Mapper class 
public class MissingCardsMapper extends MapReduceBase implements
		Mapper<Text, /* Input key Type */
				Text, /* Input value Type */
				Text, /* Output key Type */
				IntWritable> /* Output value Type */
{

	// Map function
	public void map(Text key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String textLine = value.toString();
		String arr[] = textLine.split(",");
		output.collect(new Text(arr[0]), new IntWritable(Integer.parseInt(arr[1])));
	}
}
