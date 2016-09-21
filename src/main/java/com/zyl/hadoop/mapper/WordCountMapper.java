/**
 * Created on 2016年9月21日
 */
package com.zyl.hadoop.mapper;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.zyl.hadoop.util.HadoopEnCodeUtil;

/**
 * @author zhuyl<a href="mailto:zhuyl@chsi.com.cn">zhu Youliang</a>
 * @version $Id$
 */
public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context) throws IOException,
            InterruptedException {
        value = HadoopEnCodeUtil.transTextToCharset(value, "UTF-8");
        StringTokenizer tokenizer = new StringTokenizer(value.toString());
        while ( tokenizer.hasMoreTokens() ) {
            word.set(tokenizer.nextToken());
            context.write(word, one);
        }
    }
}