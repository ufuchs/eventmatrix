/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

import org.apache.commons.cli.Options;

public class FreeDays {

	private static int O_OPT = 0;
	private static int O_LONGOPT = 1;
	private static int O_HASARG = 2;
	private static int O_DESC = 3;
	
	/**
	 * command line options
	 */
	private static Object[][] OPTION_DESCS = new Object[][] {
		
		{ "a", "all", false, "do not hide entries starting with ." },
		{ "A", "almost-all", false, "do not list implied . and .." } 
		
	};
	
	/**
	 * 
	 * @author ufuchs
	 *
	 */
	public static class CliOptionProvider {
		
		private Options options = new Options();
		
		/**
		 * 
		 * @param options
		 */
		public void populateOptions(Object[][] optionsDescs) {
			
			for (Object[] optionDesc : optionsDescs) {
				
				String opt = (String) optionDesc[O_OPT];
				String longOpt = (String) optionDesc[O_LONGOPT];
				boolean hasArg = (Boolean) optionDesc[O_HASARG];
				String desc = (String) optionDesc[O_DESC];
				
				if ("".equals(longOpt)) {
					options.addOption(opt, hasArg, desc);
				} else {
					options.addOption(opt, longOpt, hasArg, desc);
				}
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * @author ufuchs
	 *
	 */
	public static class FreeDayOptions {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CliOptionProvider op = new CliOptionProvider();
		op.populateOptions(OPTION_DESCS);
		
		System.out.print("test");
		
	}

}
