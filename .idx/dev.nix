# To learn more about how to use Nix to configure your environment
# see: https://firebase.google.com/docs/studio/customize-workspace
{ pkgs, ... }: {
  # Which nixpkgs channel to use.
  channel = "stable-23.11"; # or "unstable"
  # Use https://search.nixos.org/packages to find packages
  packages = [
    pkgs.zulu17
    pkgs.postgresql
    pkgs.maven
  ];
  # Sets environment variables in the workspace
  env = {};
  idx = {
    # Search for the extensions you want on https://open-vsx.org/ and use "publisher.id"
    extensions = [
      "vscjava.vscode-java-pack"
      "rangav.vscode-thunder-client"
    ];
    workspace = {
      # Runs when a workspace is first created with this `dev.nix` file
      onCreate = {
        install = "mvn clean install";
      };
      # Runs when a workspace is (re)started
      onStart = {
        run-server = "PORT=3000 mvn spring-boot:run";
      };
    };
    previews = {
      enable = true;
      previews = {
        web = {
          command = [
              "mvn"
              "spring-boot:run"
            ];
            manager = "web";
        };
        web2 = {
            command = [
              "npm"
              "run"
              "dev"
              "--"
              "--port"
              "$PORT"
            ];
            manager = "web";
            cwd = "frontend";
        };
      };
    };
  };
}
