package com.gain.java.knowledge.spouts;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class Spouts extends BaseRichSpout{

	private SpoutOutputCollector collector;
	Integer number = 1;
	
	public void nextTuple() {
		collector.emit(new Values(new Integer(number++)));
		
	}

	public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector collector) {
		this.collector= collector;
		
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("number"));
	}

}
