/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residents.hospitals;

import java.util.Objects;

/**
 *
 * @author stefan
 */
public class MatchingStable {

    private Resident resident;
    private Hospital hospital;

    public MatchingStable(Resident resident, Hospital hospital) {
        this.resident = resident;
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "MatchingStable{" + "resident=" + resident + ", hospital=" + hospital + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatchingStable other = (MatchingStable) obj;
        if (!Objects.equals(this.resident, other.resident)) {
            return false;
        }
        if (!Objects.equals(this.hospital, other.hospital)) {
            return false;
        }
        return true;
    }

}
