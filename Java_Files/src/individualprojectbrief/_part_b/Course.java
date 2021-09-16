/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief._part_b;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author haris
 */
public class Course
{
    private String courseTitle;
    private String courseType;
    private String runTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private float attendPrice;
    

    public Course(String courseTitle, String courseType, String runTime,
            LocalDate startDate, LocalDate endDate, float attendPrice)
    {
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.runTime = runTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attendPrice = attendPrice;
    }

    public Course()
    {
        
    }

    public String getCourseTitle()
    {
        return courseTitle;
    }

    public String getCourseType()
    {
        return courseType;
    }

    public String getRunTime()
    {
        return runTime;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public float getAttendPrice()
    {
        return attendPrice;
    }
    
    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }

    public void setCourseType(String courseType)
    {
        this.courseType = courseType;
    }

    public void setRunTime(String runTime)
    {
        this.runTime = runTime;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    public void setAttendPrice(float attendPrice)
    {
        this.attendPrice = attendPrice;
    }
    
        @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.courseTitle);
        hash = 13 * hash + Objects.hashCode(this.courseType);
        hash = 13 * hash + Objects.hashCode(this.runTime);
        hash = 13 * hash + Objects.hashCode(this.startDate);
        hash = 13 * hash + Objects.hashCode(this.endDate);
        hash = 13 * hash + Float.floatToIntBits(this.attendPrice);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Course other = (Course) obj;
        if (Float.floatToIntBits(this.attendPrice) != Float.floatToIntBits(other.attendPrice))
        {
            return false;
        }
        if (!Objects.equals(this.courseTitle, other.courseTitle))
        {
            return false;
        }
        if (!Objects.equals(this.courseType, other.courseType))
        {
            return false;
        }
        if (!Objects.equals(this.runTime, other.runTime))
        {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate))
        {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate))
        {
            return false;
        }
        return true;
    }

}
