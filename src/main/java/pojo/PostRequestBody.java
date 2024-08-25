package pojo;

import java.util.List;

public class PostRequestBody {

    private Needs needs;
    private List<String> pincodes;

    public Needs getNeeds() {
        return needs;
    }

    public void setNeeds(Needs needs) {
        this.needs = needs;
    }

    public List<String> getPincodes() {
        return pincodes;
    }

    public void setPincodes(List<String> pincodes) {
        this.pincodes = pincodes;
    }
}

