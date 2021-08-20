package Service.operatorUserInput;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperatorUserInputNew {

    private String operatorId;
    private List<OperatorUserInput.TopLevelDocument> topLevelDocuments;
    private List<SellerDetermination> sellerDetermination;
    private List<Layout> layouts;
    private List<Field> fields;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public List<OperatorUserInput.TopLevelDocument> getTopLevelDocuments() {
        return topLevelDocuments;
    }

    public void setTopLevelDocuments(List<OperatorUserInput.TopLevelDocument> topLevelDocuments) {
        this.topLevelDocuments = topLevelDocuments;
    }

    public List<SellerDetermination> getSellerDetermination() {
        return sellerDetermination;
    }

    public void setSellerDetermination(List<SellerDetermination> sellerDetermination) {
        this.sellerDetermination = sellerDetermination;
    }

    public List<Layout> getLayouts() {
        return layouts;
    }

    public void setLayouts(List<Layout> layouts) {
        this.layouts = layouts;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public static class SellerDetermination {
        private String identifier;  //seller_id
        private Map<String, String> linkedCombinations;

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public Map<String, String> getLinkedCombinations() {
            return linkedCombinations;
        }

        public void setLinkedCombinations(Map<String, String> linkedCombinations) {
            this.linkedCombinations = linkedCombinations;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Layout {
        private String identifier;
        private List<Integer> linkedLabels;
        private Boolean viewBill;
        private List<LabelMapping> labelMapping;
        private Boolean isAmountRequired;

        public Boolean getIsAmountRequired() {
            return isAmountRequired;
        }

        public void setIsAmountRequired(Boolean isAmountRequired) {
            isAmountRequired = isAmountRequired;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public List<Integer> getLinkedLabels() {
            return linkedLabels;
        }

        public void setLinkedLabels(List<Integer> linkedLabels) {
            this.linkedLabels = linkedLabels;
        }

        public Boolean getViewBill() {
            return viewBill;
        }

        public void setViewBill(Boolean viewBill) {
            this.viewBill = viewBill;
        }

        public List<LabelMapping> getLabelMapping() {
            return labelMapping;
        }

        public void setLabelMapping(List<LabelMapping> labelMapping) {
            this.labelMapping = labelMapping;
        }
    }


    public static class LabelMapping {
        private String fieldName;
        private List<Integer> labels;
        private String separator;

        public String getSeparator() {
            return separator;
        }

        public void setSeparator(String separator) {
            this.separator = separator;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public List<Integer> getLabels() {
            return labels;
        }

        public void setLabels(List<Integer> labels) {
            this.labels = labels;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Field {
        private String identifier;
        private String id;
        private String fieldKey;
        private String name;
        private String type;
        private String regex;
        private String icon;
        private Boolean isnumeric;
        private Boolean isDecimal;
        private Boolean isAllCaps;
        private Boolean password;
        private Integer max;
        private Integer min;
        private Integer maxLen;
        private String[] fieldValues;
        private String desc;
        private Boolean optional;
        private String prefix;
        private List<Field> options;
        private String hint;
        private String rightIcon;
        private Integer textSize;
        private String typeFace;
        private String textColor;
        private Boolean skipIfConnection;


        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getFieldKey() {
            return fieldKey;
        }

        public void setFieldKey(String fieldKey) {
            this.fieldKey = fieldKey;
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRegex() {
            return regex;
        }

        public void setRegex(String regex) {
            this.regex = regex;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Boolean getIsnumeric() {
            return isnumeric;
        }

        public void setIsnumeric(Boolean isnumeric) {
            this.isnumeric = isnumeric;
        }

        public Boolean getIsDecimal() {
            return isDecimal;
        }

        public void setIsDecimal(Boolean isDecimal) {
            isDecimal = isDecimal;
        }

        public Boolean getIsAllCaps() {
            return isAllCaps;
        }

        public void setIsAllCaps(Boolean isAllCaps) {
            isAllCaps = isAllCaps;
        }

        public Boolean getPassword() {
            return password;
        }

        public void setPassword(Boolean password) {
            this.password = password;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        public Integer getMaxLen() {
            return maxLen;
        }

        public void setMaxLen(Integer maxLen) {
            this.maxLen = maxLen;
        }

        public String[] getFieldValues() {
            return fieldValues;
        }

        public void setFieldValues(String[] fieldValues) {
            this.fieldValues = fieldValues;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Boolean getOptional() {
            return optional;
        }

        public void setOptional(Boolean optional) {
            this.optional = optional;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public List<Field> getOptions() {
            return options;
        }

        public void setOptions(List<Field> options) {
            this.options = options;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getRightIcon() {
            return rightIcon;
        }

        public void setRightIcon(String rightIcon) {
            this.rightIcon = rightIcon;
        }

        public Integer getTextSize() {
            return textSize;
        }

        public void setTextSize(Integer textSize) {
            this.textSize = textSize;
        }

        public String getTypeFace() {
            return typeFace;
        }

        public void setTypeFace(String typeFace) {
            this.typeFace = typeFace;
        }

        public String getTextColor() {
            return textColor;
        }

        public void setTextColor(String textColor) {
            this.textColor = textColor;
        }

        public Boolean getSkipIfConnection() {
            return skipIfConnection;
        }

        public void setSkipIfConnection(Boolean skipIfConnection) {
            this.skipIfConnection = skipIfConnection;
        }

        public String getId() {
            return fieldKey;
        }

        public void setId(String id) {
            this.id = id;
        }
    }


}

