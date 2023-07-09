Pod::Spec.new do |spec|
    spec.name                     = 'sqlcipher_ktn_pod'
    spec.version                  = '1.4.1'
    spec.homepage                 = 'https://github.com/softartdev/sqlcipher-ktn-pod'
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Wrap SQLCipher lib from Cocoapods to Kotlin Native'
    spec.vendored_frameworks      = 'build/cocoapods/framework/SQLCipher pod on Kotlin Native.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '13.5'
    spec.dependency 'SQLCipher', '~> 4.5'
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => '',
        'PRODUCT_MODULE_NAME' => 'SQLCipher pod on Kotlin Native',
    }
                
    spec.script_phases = [
        {
            :name => 'Build sqlcipher_ktn_pod',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
                
end