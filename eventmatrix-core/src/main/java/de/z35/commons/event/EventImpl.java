/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.event;

import java.util.Calendar;

public class EventImpl implements Event {

	/**
	 * 
	 *
     * @param classifier
     * @param classifierVerbally
     *@param dateAt  @return
	 */
	public static Event createEvent(Integer classifier, 
			String classifierVerbally, Calendar dateAt) {
		
		Event e= new EventImpl();
		
		e.setClassifier(classifier);
		e.setClassifierVerbally(classifierVerbally);
		e.setDateAt(dateAt);
		
		return e;
				
	}

	private Integer classifier;
	private Calendar dateAt;
    private String classifierVerbally;

	/* (non-Javadoc)
	 * @see de.z35.commons.event.Event#getClassifier()
	 */
	public Integer getClassifier() {
		return this.classifier;
	}

	/* (non-Javadoc)
	 * @see de.z35.commons.event.Event#setClassifier(java.lang.Integer)
	 */
	public void setClassifier(Integer id) {
		this.classifier = id;
	}

    public String getClassifierVerbally() {
        return this.classifierVerbally;
    }

    public void setClassifierVerbally(String desc) {
        this.classifierVerbally = desc;
    }

    /* (non-Javadoc)
      * @see de.z35.commons.event.Event#getDateAt()
      */
	public Calendar getDateAt() {
		return this.dateAt;
	}

	/* (non-Javadoc)
	 * @see de.z35.commons.event.Event#setDateAt(java.util.Calendar)
	 */
	public void setDateAt(Calendar dateAt) {
		this.dateAt = dateAt;
	}
	
	/**
	 * 
	 */
	public boolean isNull() {
		return false;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("classifier : ")
			.append(classifier)
			.append(" | ");
        sb.append("classifierVerbally : ")
        	.append(classifierVerbally)
        	.append(" | ");
		sb.append("dateAt : ")
			.append(dateAt.get(Calendar.YEAR))
			.append("-")			
			.append(dateAt.get(Calendar.MONTH) + 1)
			.append("-")
			.append(dateAt.get(Calendar.DATE))
			.append("\n");
		
		return sb.toString();
		
	}

}
