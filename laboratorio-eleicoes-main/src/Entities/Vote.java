package Entities;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

public class Vote {
    private Candidate candidate;
    private Date creationDate;
    private boolean valid = true;
    private String error;

    public Vote(Candidate candidate) {
        this.candidate = candidate;

        try {
            this.creationDate = obtainUtcNow();
        } catch (ParseException ex) {
            this.valid = false;
            this.error = ex.getLocalizedMessage();
        }
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private Date obtainUtcNow() throws ParseException {
        return Date.from(Instant.now());
    }
}
