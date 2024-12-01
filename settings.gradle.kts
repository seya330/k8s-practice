rootProject.name = "k8s-practice"

include(
    "order:core",
    "order:application",
    "order:adapter-web",
    "order:adapter-persistence",

    "product:core",
    "product:application",
    "product:adapter-web",
    "product:adapter-persistence",

    "cart"
)