## Change log
----------------------

Version 2.2-SNAPSHOT
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


