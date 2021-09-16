/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief._part_b;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author haris
 */
public class Assignment
{
    private String asgnmtTitle;
    private LocalDate submitDate;
    

    public Assignment(String asgnmtTitle, LocalDate submitTime)
    {
        this.asgnmtTitle = asgnmtTitle;
        this.submitDate = submitTime;
        
    }

    public Assignment()
    {
        
    }

    public String getAsgnmtTitle()
    {
        return asgnmtTitle;
    }

    public LocalDate getSubmitDate()
    {
        return submitDate;
    }


    public void setAsgnmtTitle(String asgnmtTitle)
    {
        this.asgnmtTitle = asgnmtTitle;
    }

    public void setSubmitDate(LocalDate submitDate)
    {
        this.submitDate = submitDate;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.asgnmtTitle);
        hash = 59 * hash + Objects.hashCode(this.submitDate);
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
        final Assignment other = (Assignment) obj;
        if (!Objects.equals(this.asgnmtTitle, other.asgnmtTitle))
        {
            return false;
        }
        if (!Objects.equals(this.submitDate, other.submitDate))
        {
            return false;
        }
        return true;
    }
    
    
}
