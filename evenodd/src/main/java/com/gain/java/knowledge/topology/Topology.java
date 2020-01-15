package com.gain.java.knowledge.topology;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

import com.gain.java.knowledge.bolts.Bolts;
import com.gain.java.knowledge.spouts.Spouts;

public class Topology {

	public static void main(String[] args) {
		TopologyBuilder builder = new TopologyBuilder();
		
		builder.setSpout("spoutId", new Spouts());
		builder.setBolt("boltId", new Bolts()).shuffleGrouping("spoutId");
		
		Config config = new Config();
		config.setDebug(false);
		
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("topology", config, builder.createTopology());
		Utils.sleep(10000);
		cluster.killTopology("topology");
		cluster.shutdown();
	}
}
