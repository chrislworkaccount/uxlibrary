const fs = require('fs')

const mIllAssetsDir = '../illustrations/onboarding/'
const masterColorProfile = 'master_color_profile_compare.json'


try {
    fs.writeFileSync(masterColorProfile, '')
} catch (e) {
    console.log("Cannot write file ", e)
}

const master = fs.readFileSync(mIllAssetsDir + fs.readdirSync(mIllAssetsDir).filter(file => file.includes('base')), 'utf8')
const themeFiles = fs.readdirSync(mIllAssetsDir).filter(file => !file.includes('base'))
var colorMaps = []

themeFiles.forEach(file => {
    var themed = fs.readFileSync(mIllAssetsDir + file, 'utf8')
    var mapped = compareToMasterAndGenerateProfiles(master, themed)
    var jsonColorProfileMap = new Map()
    jsonColorProfileMap['version'] = file
    jsonColorProfileMap['colormaps'] = mapped
    colorMaps.push(jsonColorProfileMap)
})
appendColorMapEntry(masterColorProfile, JSON.stringify(colorMaps))

function appendColorMapEntry(file, colormap) {
    fs.appendFile(file, colormap, function (err) {
        if (err) throw err
    })
}

function compareToMasterAndGenerateProfiles(base, other) {
    const master = JSON.parse(base)
    const themed = JSON.parse(other)

    let profileColorMaps = []

    for (var i = 0; i < master.layers.length; i++) {
        if (master.layers[i].shapes !== undefined) {
            for (var j = 0; j < master.layers[i].shapes.length; j++) {
                for (var t = 0; t < master.layers[i].shapes[j].it.length; t++) {
                    if ((master.layers[i].shapes[j].it[t].c !== undefined) && (master.layers[i].shapes[j].it[t].c.k !== undefined)) {
                        const keypath = master.layers[i].nm + ',' + master.layers[i].shapes[j].nm + ',' + master.layers[i].shapes[j].it[t].nm
                        const color = master.layers[i].shapes[j].it[t].c.k
                        const themedColor = themed.layers[i].shapes[j].it[t].c.k                       

                        if (color !== themedColor ) {
                            const hex = rgbToHex(themedColor[0], themedColor[1], themedColor[2], themedColor[3]).toUpperCase()
                            const diffs = new Map()
                            diffs['keypath'] = keypath
                            diffs['color'] = hex

                            profileColorMaps.push(diffs)
                        }

                    } else { appendColorMapEntry(masterColorProfile, '') }
                }
            }

        }

    }
    return profileColorMaps
}

function componentToHex(c) {
    const h = Math.floor(c * 255)
    var hex = h.toString(16)
    return hex.length == 1 ? "0" + hex : hex
  }
  
  function rgbToHex(r, g, b, a) {
    return "#" + componentToHex(a) + componentToHex(r) + componentToHex(g) + componentToHex(b)
  }
