import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class MissingCardsReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, Text> {

	@Override
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, Text> output,
			Reporter reporter) throws IOException {
		List<Integer> valueList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		while (values.hasNext()) {
			valueList.remove(values.next());

		}
		 output.collect(key, new Text(valueList.toString()));
	}

}
