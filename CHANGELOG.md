## Change log
----------------------

Version 2.5-SNAPSHOT
-------------

ADDED:
 
- added new test-dependency junit-jupiter (junit 5) in version 5.6.2

CHANGED:

- update gradle to new version 6.5.1
- remove of test-dependency testng 

Version 2.4
-------------

ADDED:
 
- migrate from maven to gradle as build system
- changed from old dozer to new model-mapper dependency

CHANGED:

- update of gradle to new version 6.5
- extracted project properties to gradle.properties

Version 2.3
-------------

ADDED:
  
- added new bean-mapper-api dependency
- new factory methods for BeanMappingBuilder and DozerBeanMapper created

CHANGED:

- update factory method newMapper in class AbstractGenericMapper 
- replaced GenericMapper interface with the same name class from the new bean-mapper-api dependency
- prepare project for migrate to gradle
- created new unit test class for the class MapperExtensions

Version 2.2
-------------

ADDED:
  
- added new mapping xml file for initialize uuid objects

CHANGED:

- update parent version to 5.5
- update dependency jobj-core to version 3.3

Version 2.1
-------------

ADDED:
  
- added new interface DozerGenericMapper which holds dozer specific default methods

CHANGED:

- removed dozer specific methods from GenericMapper and moved to new interface DozerGenericMapper

Version 2
-------------

CHANGED:

- removed methods toDomainObject and toDomainObjects that was tagged as deprecated
- renamed EntityDOMapper to GenericMapper and AbstractEntityDOMapper to AbstractGenericMapper

Version 1.1
-------------

ADDED:
  
- added new methods to interface EntityDOMapper toDto and toDtos and tagged methods toDomainObject and toDomainObjects as deprecated

CHANGED:

- update parent version to 5.3
- made all methods null safe

Version 1
-------------

ADDED:
  
- moved classes from obsolet domain-mapper project
- this changelog file
- created PULL_REQUEST_TEMPLATE.md file
- created CODE_OF_CONDUCT.md file
- created CONTRIBUTING.md file


