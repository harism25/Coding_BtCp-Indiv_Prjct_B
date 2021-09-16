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
public class Student
{
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private float schoolFees;

    public Student(String surname, String name, LocalDate dateOfBirth,
            float schoolFees)
    {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.schoolFees = schoolFees;
    }

    public Student()
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

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public float getSchoolFees()
    {
        return schoolFees;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSchoolFees(float schoolFees)
    {
        this.schoolFees = schoolFees;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.surname);
        hash = 89 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 89 * hash + Float.floatToIntBits(this.schoolFees);
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
        final Student other = (Student) obj;
        if (Float.floatToIntBits(this.schoolFees) != Float.floatToIntBits(other.schoolFees))
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname))
        {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth))
        {
            return false;
        }
        return true;
    }
   
    
}
