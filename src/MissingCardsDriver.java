
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class MissingCardsDriver {

	public static void main(String[] args) throws Exception {
		JobConf conf = new JobConf(MissingCardsDriver.class);
		conf.setJobName("Missing Cards Job");
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		conf.setMapperClass(MissingCardsMapper.class);
		conf.setReducerClass(MissingCardsReducer.class);
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		JobClient.runJob(conf);

		// Job job = Job.getInstance(new Configuration(), "Missing Cards Job");
		// job.setJarByClass(MissingCardsDriver.class);
		// TextInputFormat.addInputPath(job, new Path(args[0]));
		// job.setInputFormatClass(TextInputFormat.class);
		// job.setMapperClass(MissingCardsMapper.class);
		// job.setReducerClass(MissingCardsReducer.class);
		// TextOutputFormat.setOutputPath(job, new Path(args[1]));
		// job.setMapOutputKeyClass(Text.class);
		// job.setMapOutputValueClass(IntWritable.class);
		// job.setOutputFormatClass(TextOutputFormat.class);
		// job.setOutputKeyClass(Text.class);
		// job.setOutputValueClass(Text.class);
		// System.exit(job.waitForCompletion(true) ? 0 : -1);
	}
}
