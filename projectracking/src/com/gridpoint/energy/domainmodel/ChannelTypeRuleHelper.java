package com.gridpoint.energy.domainmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Helper to generate statistics on the effectiveness of rule classification.
 */
public class ChannelTypeRuleHelper {
    private static final Logger log = Logger.getLogger(ChannelTypeRuleHelper.class);

    /**
     * Pojo which represents a rule's effectiveness.  Contains the total
     * number of channel types matched, and the total number of channel
     * instances matched.
     */
    public static class Statistics implements java.io.Serializable {
        public static final long serialVersionUID = 1L;

        public Statistics(Rule rule) {
            this.rule = rule;
        }

        /** The rule the statistics are for. */
        private final Rule rule;

        /** Number of channel types this rule matched. */
        private int channels;

        /** Number of instances this rule matched. */
        private int instances;

        public Rule getRule() {
            return rule;
        }

        public int getChannels() {
            return channels;
        }

        public void setChannels(int channels) {
            this.channels = channels;
        }

        public int getInstances() {
            return instances;
        }

        public void setInstances(int instances) {
            this.instances = instances;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Statistics that = (Statistics) o;

            if (channels != that.channels) return false;
            if (instances != that.instances) return false;
            if (rule != null ? !rule.equals(that.rule) : that.rule != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = rule != null ? rule.hashCode() : 0;
            result = 31 * result + channels;
            result = 31 * result + instances;
            return result;
        }

        @Override
        public String toString() {
            return "Statistics{" +
                    "rule=" + rule +
                    ", channels=" + channels +
                    ", instances=" + instances +
                    '}';
        }
    }

    /**
     * Pojo representation of a <code>ChannelTypeRuleEntity</code>.
     */
    public static class Rule implements java.io.Serializable {
        public static final long serialVersionUID = 1L;

        /** Regex to match against a channel's name. */
        private final String channelName;

        /** Regex to match against a channel's data dictionary type's unit. */
        private final String unit;

        /** Name of the system the channel will be mapped to. */
        private final String systemName;

        /** Name of the device a channel will be mapped to. */
        private final String deviceName;


        public Rule(String channelName, String unit, String systemName, String deviceName) {
            this.channelName = channelName;
            this.unit = unit;
            this.systemName = systemName;
            this.deviceName = deviceName;
        }

        public String getChannelName() {
            return channelName;
        }

        public String getUnit() {
            return unit;
        }

        public String getSystemName() {
            return systemName;
        }

        public String getDeviceName() {
            return deviceName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Rule rule = (Rule) o;

            if (channelName != null ? !channelName.equals(rule.channelName) : rule.channelName != null) return false;
            if (deviceName != null ? !deviceName.equals(rule.deviceName) : rule.deviceName != null) return false;
            if (systemName != null ? !systemName.equals(rule.systemName) : rule.systemName != null) return false;
            if (unit != null ? !unit.equals(rule.unit) : rule.unit != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = channelName != null ? channelName.hashCode() : 0;
            result = 31 * result + (unit != null ? unit.hashCode() : 0);
            result = 31 * result + (systemName != null ? systemName.hashCode() : 0);
            result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Rule{" +
                    "channelName='" + channelName + '\'' +
                    ", unit='" + unit + '\'' +
                    ", systemName='" + systemName + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    '}';
        }
    }
    
    /**
     * Return type for classification, specifying all systems and devices
     * a given channel should be mapped to.
     */
    public static class Classification implements java.io.Serializable {
        public static final long serialVersionUID = 1L;

        /** List of all system names a channel should be mapped to. */
        private final List<String> systems;

        /** List of all device names a channel should be mapped to. */
        private final List<String> devices;

        public Classification(List<String> systems, List<String> devices) {
            this.systems = systems;
            this.devices = devices;
        }

        public List<String> getSystems() {
            return systems;
        }

        public List<String> getDevices() {
            return devices;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Classification that = (Classification) o;

            if (devices != null ? !devices.equals(that.devices) : that.devices != null) return false;
            if (systems != null ? !systems.equals(that.systems) : that.systems != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = systems != null ? systems.hashCode() : 0;
            result = 31 * result + (devices != null ? devices.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Classification{" +
                    "systems=" + systems +
                    ", devices=" + devices +
                    '}';
        }
    }

    /**
     * Classifies a channel into systems and devices, according to a given set
     * of <code>Rule<code>s.
     */
    public static Classification classify(ChannelType channel, Collection<Rule> rules) {
        List<String> systems = new ArrayList<String>();
        List<String> devices = new ArrayList<String>();

        // loop over each rule.
        for (Rule rule : rules) {
            try {
                // if the rule matches both name and unit, we'll add it
                // to the list.
                if (channel.getName().matches(rule.getChannelName()) &&
                    channel.getUnit().matches(rule.getUnit())) {
                    
                    if (rule.getSystemName() != null) {
                        systems.add(rule.getSystemName());
                    }
                    
                    if (rule.getDeviceName() != null) {
                        devices.add(rule.getDeviceName());
                    }
                }
            } catch (Exception ex) {
                // xxx - better error handling.
                // it is possible that the regex is invalid,
                // we'll catch and log for now.
                log.error(ex);
            }
        }

        return new Classification(systems, devices);
    }

    /**
     * Return a map of statistics on the effectiveness of a set of rules.
     * Very expensive opperation, loops rules * channels number of times.
     *
     * @param channels map of channel type to instances
     * @param rules a collection of rules to match against.
     *
     * @return one entry per <code>Rule</code> in the inputs.
     */
    public static Map<Rule, Statistics> statistics(Map<ChannelType,Integer> channels, Collection<Rule> rules) {
        Map<Rule, Statistics> stats = new HashMap<Rule, Statistics>();

        for (Rule rule : rules) {
            // always add an entry for the rule, even if it never matches a
            // channel.  we can see that it's not effective then.
            stats.put(rule, new Statistics(rule));

            for (ChannelType channel : channels.keySet()) {
                try {
                    if (channel.getName().matches(rule.getChannelName()) &&
                        channel.getUnit().matches(rule.getUnit())) {
                        
                        Integer value = channels.get(channel);
                        
                        // if it matched a channel
                        if (value != null) {
                            Statistics stat = stats.get(rule);
                            // increment the number of channel types matched
                            stat.setChannels(stat.getChannels() + 1);
                            // increment the number of channel instances matched.
                            stat.setInstances(stat.getInstances() + value.intValue());
                        }
                    }
                } catch (Exception ex) {
                    log.error(ex);
                }
            }
        }
         
        return stats;
    }
}