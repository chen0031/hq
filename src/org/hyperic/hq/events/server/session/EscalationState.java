package org.hyperic.hq.events.server.session;

import org.hyperic.hibernate.PersistedObject;
import org.hyperic.hq.Json;
import org.json.JSONObject;
import org.json.JSONException;
// Generated Nov 19, 2006 9:02:06 AM by Hibernate Tools 3.2.0.beta8


/**
 * EscalationState generated by hbm2java
 */
public class EscalationState extends PersistedObject
        implements Cloneable, Json
{
    public static EscalationState newInstance(Escalation e, Integer aid)
    {
        return new EscalationState(e, aid.intValue());
    }

    // Fields
    /**
     * The current escalation leven in the chain.  I.e.,
     * current escalation level == actions[currentLevel].
     */
    private int currentLevel;
    /**
     * If true, then wait for
     * max(pauseWaitTime, EscalationAction.waitTime)
     * else wait for
     * EscalationAction.waitTime
     * before escalating up the chain.
     */
    private boolean pauseEscalation;

    /**
     * >0 next scheduled run time.
     * =0 not scheduled.
     */
    private long scheduleRunTime;

    /**
     * meaningful if pauseEscalation == true.
     * (pauseWaitTime <= maxWaitTime)
     */
    private long pauseWaitTime;
    /**
     * If fixed, then stop escalation chain. (terminal condition)
     */
    private boolean fixed;
    /**
     * "updateBy" has taken ownership of this issue at the
     * current escalation level.
     */
    private boolean acknowledge;
    /**
     * Escalation is in progress.
     */
    private boolean active;
    private String updateBy;
    private long creationTime;
    /**
     * timestamp is updated on state change.
     */
    private long modifiedTime;
    private Escalation escalation;
    private int alertDefinitionId;
    private int alertId;

    // Constructors

    /**
     * default constructor
     */
    protected EscalationState()
    {
    }

    protected EscalationState(Escalation e, int aid)
    {
        escalation = e;
        alertDefinitionId = aid;
    }

    /**
     * *         The current escalation leven in the chain.  I.e.,
     * current escalation level == actions[currentLevel].
     */
    public int getCurrentLevel()
    {
        return this.currentLevel;
    }

    public void setCurrentLevel(int currentLevel)
    {
        this.currentLevel = currentLevel;
    }

    /**
     * *         If true, then wait for
     * max(pauseWaitTime, EscalationAction.waitTime)
     * else wait for
     * EscalationAction.waitTime
     * before escalating up the chain.
     */
    public boolean isPauseEscalation()
    {
        return this.pauseEscalation;
    }

    public void setPauseEscalation(boolean pauseEscalation)
    {
        this.pauseEscalation = pauseEscalation;
    }

    public long getScheduleRunTime()
    {
        return scheduleRunTime;
    }

    public void setScheduleRunTime(long scheduleRunTime)
    {
        this.scheduleRunTime = scheduleRunTime;
    }

    /**
     * *         meaningful if pauseEscalation == true.
     * (pauseWaitTime <= maxWaitTime)
     */
    public long getPauseWaitTime()
    {
        return this.pauseWaitTime;
    }

    public void setPauseWaitTime(long pauseWaitTime)
    {
        this.pauseWaitTime = pauseWaitTime;
    }

    /**
     * *         If fixed, then stop escalation chain. (terminal condition)
     */
    public boolean isFixed()
    {
        return this.fixed;
    }

    public void setFixed(boolean fixed)
    {
        this.fixed = fixed;
    }

    /**
     * *         "updateBy" has taken ownership of this issue at the
     * current escalation level.
     */
    public boolean isAcknowledge()
    {
        return this.acknowledge;
    }

    public void setAcknowledge(boolean acknowledge)
    {
        this.acknowledge = acknowledge;
    }

    /**
     * *         Escalation is in progress.
     */
    public boolean isActive()
    {
        return this.active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getUpdateBy()
    {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    public long getCreationTime()
    {
        return this.creationTime;
    }

    public void setCreationTime(long creationTime)
    {
        this.creationTime = creationTime;
    }

    /**
     * *         timestamp is updated on state change.
     */
    public long getModifiedTime()
    {
        return this.modifiedTime;
    }

    public void setModifiedTime(long modifiedTime)
    {
        this.modifiedTime = modifiedTime;
    }

    public Escalation getEscalation()
    {
        return this.escalation;
    }

    public void setEscalation(Escalation escalation)
    {
        this.escalation = escalation;
    }

    public int getAlertDefinitionId()
    {
        return this.alertDefinitionId;
    }

    public void setAlertDefinitionId(int alertDefinitionId)
    {
        this.alertDefinitionId = alertDefinitionId;
    }

    public int getAlertId()
    {
        return alertId;
    }

    public void setAlertId(int alertId)
    {
        this.alertId = alertId;
    }

    public JSONObject toJSON() throws JSONException
    {
        return new JSONObject()
                .put("id", getId())
                .put("currentLevel", currentLevel)
                .put("creationTime", creationTime)
                .put("modifiedTime", modifiedTime)
                .put("pauseWaitTime", pauseWaitTime)
                .put("scheduleRunTime", scheduleRunTime)
                .put("acknowledge", acknowledge)
                .put("fixed", fixed)
                .put("active", active)
                .put("pauseEscalation", pauseEscalation)
                .put("alertDefinitionId", alertDefinitionId)
                .put("alertId", alertId)
                .put("escalationId", escalation.getId())
                .put("updateBy", updateBy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EscalationState)) {
            return false;
        }
        EscalationState o = (EscalationState)obj;

        return currentLevel == o.getCurrentLevel() &&
               creationTime == o.getCreationTime() &&
               modifiedTime == o.getModifiedTime() &&
               pauseWaitTime == o.getPauseWaitTime() &&
               scheduleRunTime == o.getScheduleRunTime() &&
               acknowledge == o.isAcknowledge() &&
               fixed == o.isFixed() &&
               active == o.isActive() &&
               pauseEscalation == o.isPauseEscalation() &&
               alertDefinitionId == o.getAlertDefinitionId() &&
               alertId == o.getAlertId() &&
               (escalation == o.getEscalation() ||
                (escalation != null && o.getEscalation() != null &&
                 updateBy.equals(o.getEscalation()) ) ) &&
               (updateBy == o.getUpdateBy() ||
                (updateBy != null && o.getUpdateBy() != null &&
                 updateBy.equals(o.getUpdateBy()) ) );
    }

    public int hashCode() {
        int result = 17;

        result = 37*result + (acknowledge ? 0 : 1);
        result = 37*result + (fixed ? 0 : 1);
        result = 37*result + (pauseEscalation ? 0 : 1);
        result = 37*result + (active ? 0 : 1);
        result = 37*result + currentLevel;
        result = 37*result + alertDefinitionId;
        result = 37*result + alertId;
        result = 37*result + (int)(creationTime ^ (creationTime >>> 32));
        result = 37*result + (int)(modifiedTime ^ (modifiedTime >>> 32));
        result = 37*result + (int)(pauseWaitTime ^ (pauseWaitTime >>> 32));
        result = 37*result + (int)(scheduleRunTime ^ (scheduleRunTime >>> 32));
        result = 37*result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 37*result + (escalation != null ? escalation.hashCode() : 0);

        return result;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch(CloneNotSupportedException e) {
            // Can't happen
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    public String toString() {
        return new StringBuffer()
            .append("(id=" + getId() + 
                    ", escalationId=" + getEscalation().getId() +
                    ", alertDefId=" + alertDefinitionId +
                    ", alertId=" + alertId +
                    ", currentLevel=" + currentLevel +
                    ", fixed=" + fixed +
                    ", active"+ active +
                    ", acknowledge=" + acknowledge +
                    ", pause=" + pauseEscalation +
                    ", scheduleRunTime=" + scheduleRunTime +
                    ", pauseWaitTIme=" + pauseWaitTime +
                    ", modified=" + modifiedTime)
            .append((updateBy != null ? (", updateBy="+updateBy) : ""))
            .append(")")
            .toString();
    }
}


