#invoke npm in jenkinsfile: sh "scl enable rh-nodejs6 'npm run build'"
FROM quay.io/openshift/origin-jenkins-agent-base:4.5

ENV NODEJS_VERSION=14 \
    NPM_CONFIG_PREFIX=$HOME/.npm-global \
    PATH=$HOME/.local/bin/:$HOME/node_modules/.bin/:$HOME/.npm-global/bin/:$PATH \
    PYTHON_VERSION=3.6 \
    PYTHONUNBUFFERED=1 \
    PYTHONIOENCODING=UTF-8 \
    LC_ALL=en_US.UTF-8 \
    LANG=en_US.UTF-8 \
    PIP_NO_CACHE_DIR=off

RUN curl --silent --location https://rpm.nodesource.com/setup_${NODEJS_VERSION}.x | bash -

RUN INSTALL_PKGS=" \
      nodejs rh-python36 rh-python36-python-devel rh-python36-python-setuptools rh-python36-python-wheel rh-python36-python-pip nss_wrapper \
      yum-utils httpd24 httpd24-httpd-devel httpd24-mod_ssl httpd24-mod_auth_kerb httpd24-mod_ldap \
      httpd24-mod_session atlas-devel gcc-gfortran libffi-devel libtool-ltdl enchant" && \
    yum $DISABLE_REPOS install -y --setopt=tsflags=nodocs --disablerepo='rhel-*' \
      $INSTALL_PKGS && \
    rpm -V $INSTALL_PKGS && \
    yum clean all -y && \
    source scl_source enable rh-python36 && \
    scl enable rh-python36 bash && \
    python3 -m pip install --upgrade pip && \
    python3 -m pip install twine
    rm -rf /var/cache/yum && \
    npm install --unsafe-perm -g npm-audit-html npm-audit-ci-wrapper sonar-scanner && \
    chown root:root /home/jenkins -R && \
    chmod 775 /home/jenkins/.config -R && \
    chmod 775 /home/jenkins/.npm -R

USER 1001
