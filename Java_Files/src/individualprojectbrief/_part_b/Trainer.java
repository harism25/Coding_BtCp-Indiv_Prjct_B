/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief._part_b;

import java.util.Objects;

/**
 *
 * @author haris
 */
public class Trainer
{
    private String name;
    private String surname;
    private String teachingCrs;

    public Trainer(String surname, String name, String teachingCrs)
    {
        this.name = name;
        this.surname = surname;
        this.teachingCrs = teachingCrs;
    }


    public Trainer()
    {
        
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getTeachingCrs()
    {
        return teachingCrs;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setTeachingCrs(String teachingCrs)
    {
        this.teachingCrs = teachingCrs;
    }
    
        @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.surname);
        hash = 61 * hash + Objects.hashCode(this.teachingCrs);
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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname))
        {
            return false;
        }
        if (!Objects.equals(this.teachingCrs, other.teachingCrs))
        {
            return false;
        }
        return true;
    }
}
