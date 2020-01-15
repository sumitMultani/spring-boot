package com.gain.java.knowledge.bolts;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

public class Bolts extends BaseRichBolt{

	private OutputCollector collector;
	
	public void execute(Tuple tuple) {
		Integer number = (Integer)tuple.getValueByField("number");
		if(number % 2 == 0)
			System.out.println(number + " is an even number");
		collector.ack(tuple);
		
	}

	public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
		this.collector = collector;
		
	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
	}

}
