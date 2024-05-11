package systemDesign.designPattern.creationalPatterns.prototype;

/**
Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement.
This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.
 */
public interface Prototype {

    Prototype getClone();
}
