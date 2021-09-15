package Service.operatorUserInput;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class OperatorUserInput {
    private int operatorId;

    private List<TopLevelDocument> topLevelDocuments;

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public List<TopLevelDocument> getTopLevelDocuments() {
        return topLevelDocuments;
    }

    public void setTopLevelDocuments(List<TopLevelDocument> topLevelDocuments) {
        this.topLevelDocuments = topLevelDocuments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OperatorUserInput{");
        sb.append("operatorId=").append(operatorId);
        sb.append(", topLevelDocuments=").append(topLevelDocuments);
        sb.append('}');
        return sb.toString();
    }

    public static class TopLevelDocument {

        private String key;
        private String keyDisplay;
        private String sendBack;
        private List<Document> documents;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getKeyDisplay() {
            return keyDisplay;
        }

        public void setKeyDisplay(String keyDisplay) {
            this.keyDisplay = keyDisplay;
        }

        public String getSendBack() {
            return sendBack;
        }

        public void setSendBack(String sendBack) {
            this.sendBack = sendBack;
        }

        public List<Document> getDocuments() {
            return documents;
        }

        public void setDocuments(List<Document> documents) {
            this.documents = documents;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TopLevelDocument{");
            sb.append("key='").append(key).append('\'');
            sb.append(", keyDisplay='").append(keyDisplay).append('\'');
            sb.append(", sendBack='").append(sendBack).append('\'');
            sb.append(", documents=").append(documents);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Document {

        private String valueDisplay;
        private String value;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String upiHandle;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean verifiedBeneficiary;
        private List<LinkedDocument> linkedDocuments;

        public String getUpiHandle() {return upiHandle; }

        public void setUpiHandle(String upiHandle) {this.upiHandle = upiHandle; }

        public Boolean getVerifiedBeneficiary() {return verifiedBeneficiary; }

        public void setVerifiedBeneficiary(Boolean verifiedBeneficiary) {this.verifiedBeneficiary = verifiedBeneficiary; }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValueDisplay() {
            return valueDisplay;
        }

        public void setValueDisplay(String valueDisplay) {
            this.valueDisplay = valueDisplay;
        }

        public List<LinkedDocument> getLinkedDocuments() {
            return linkedDocuments;
        }

        public void setLinkedDocuments(List<LinkedDocument> linkedDocuments) {
            this.linkedDocuments = linkedDocuments;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Document{");
            sb.append("value='").append(value).append('\'');
            sb.append(", valueDisplay='").append(valueDisplay).append('\'');
            sb.append(", upiHandle='").append(upiHandle).append('\'');
            sb.append(", verifiedBeneficiary='").append(verifiedBeneficiary).append('\'');
            sb.append(", linkedDocuments=").append(linkedDocuments);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class LinkedDocument {

        private String key;
        private List<Integer> linkedValues;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<Integer> getLinkedValues() {
            return linkedValues;
        }

        public void setLinkedValues(List<Integer> linkedValues) {
            this.linkedValues = linkedValues;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("LinkedDocument{");
            sb.append("key='").append(key).append('\'');
            sb.append(", linkedValues=").append(linkedValues);
            sb.append('}');
            return sb.toString();
        }
    }
}
