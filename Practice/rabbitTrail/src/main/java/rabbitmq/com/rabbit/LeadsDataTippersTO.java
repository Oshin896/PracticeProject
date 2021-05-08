package rabbitmq.com.rabbit;

import lombok.Data;

@Data
public class LeadsDataTippersTO {

    private String partnersLeadId;
    private String channel;
    private String partnersStatus;
    private String opportunityId;
    private String status;
    private String createDate;
}
