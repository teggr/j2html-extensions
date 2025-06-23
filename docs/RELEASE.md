# Release the artefacts to maven

```shell
# clear out 
mvn clean

# tag the code
git tag <version>

# set the version for all extensions and then the spring boot app
mvn -Pcentral versions:set -DremoveSnapshot -DprocessAllModules
mvn -Pcentral --projects j2html-generator versions:set -DremoveSnapshot
mvn -Pcentral --projects j2html-example-webapp versions:set -DremoveSnapshot

# check that the poms are correct
mvn -Pcentral org.kordamp.maven:pomchecker-maven-plugin:1.14.0:check-maven-central
# deploy new version to central
mvn -Pcentral deploy -DignorePublishedComponents=true

# set the new versions for all extensions and then the spring boot app
mvn -Pcentral versions:set -DnextSnapshot -DprocessAllModules
mvn -Pcentral --projects j2html-generator versions:set -DnextSnapshot
mvn -Pcentral --projects j2html-example-webapp versions:set -DnextSnapshot

# set the new versions for all extensions and then the spring boot app
mvn -Pcentral versions:commit -DprocessAllModules
mvn -Pcentral --projects j2html-generator versions:commit
mvn -Pcentral --projects j2html-example-webapp versions:commit

# commit and push the github repo

# create github release
https://github.com/teggr/j2html-extensions/releases
```

For manual publishing: https://central.sonatype.com/publishing/deployments (GH)
