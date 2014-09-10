package com.impetus.codeBase;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MapperNLineInputFormat extends
Mapper<LongWritable, Text, NullWritable, Text>{
		 
		 @Override
		 public void map(LongWritable key, Text value,Context context)
		 throws IOException, InterruptedException {
			 
		 System.out.println("Actual Value >>>>>>"+value);
		  
		 context.write(NullWritable.get(), value);
		 }
}
